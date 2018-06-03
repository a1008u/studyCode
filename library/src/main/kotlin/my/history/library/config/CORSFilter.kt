package my.history.library.config

import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletResponse
import java.io.IOException
import javax.servlet.*


@Component
class SimpleCORSFilter : Filter {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
        val response = res as HttpServletResponse
        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
        response.setHeader("Access-Control-Max-Age", "3600")
        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Headers, Content-Type, X-Auth-Token, x-requested-with")
        chain.doFilter(req, res)
    }

    override fun init(filterConfig: FilterConfig) {}

    override fun destroy() {}
}
