package lake.pool.webmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    /*
    서블릿 컨테이너 구동시 최초 1회 호출
    로직처리를 모든 서브릿이 로딩이 되도록 호출하도록 처리한다. (미리 bean 객체들 등록하여 실제 호출시에는 bean 생성 없어서 good)
     */
    @Override
    public void init() throws ServletException {
        System.out.println("init");
        super.init();
    }

    /*
    http 요청에 따라 doGet, doPost, doDelete 이러한 메서드들이 호출됨
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        super.doGet(req, resp);
    }


    /*
    서브릿 컨테이너가 죽을때 1회 호출
    */
    @Override
    public void destroy(){
        System.out.println("destroy");
    }
}
