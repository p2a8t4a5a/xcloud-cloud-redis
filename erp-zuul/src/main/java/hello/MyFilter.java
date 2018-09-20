package hello;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class MyFilter  extends ZuulFilter {

    private static final String URI = "/static";

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        String path = RequestContext.getCurrentContext().getRequest().getRequestURI();
        if (checkPath(path))
            return true;
        if (checkPath("/" + path))
            return true;
        return false;
    }

    private boolean checkPath(String path) {
        return URI.equals(path);
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // Set the default response code for static filters to be 200
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        // first StaticResponseFilter instance to match wins, others do not set body
        // and/or status
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody("Hello World");
            ctx.setSendZuulResponse(false);
        }
        return null;
    }
}