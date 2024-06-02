package part2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlorServlet
 */
@WebServlet({"/AddForm","/pageList","/pageAdd","/modifierNomCarnet","/modifierAdress","/deleteAdress","/deleteCarnet"})
public class ControlorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarnetAdressImpl CarAdr;
	CarnetModel model;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	model = new CarnetModel();
    	CarAdr=new CarnetAdressImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String path =request.getServletPath();
	System.out.print(path.equals("/AddForm"));
	if(path.equals("/AddForm"))request.getRequestDispatcher("/partDAO/AddForm.html").forward(request, response);
	if (path.equals("/pageList")) {
		model.list(CarAdr.listAdresse(),CarAdr.listCarnet(),CarAdr.listAdresseParCarnet());
		request.getRequestDispatcher("/partDAO/listCarnet.jsp").forward(request, response);
	}
	if (path.equals("/modifierNomCarnet")) {
		request.getRequestDispatcher("/partDAO/updateCarnet.jsp").forward(request, response);
	}
    if (path.equals("/modifierAdress")) {
    	request.getRequestDispatcher("/partDAO/updateAdr.jsp").forward(request, response);
    	
	}
    if (path.equals("/deleteCarnet")) {
    	int id=Integer.parseInt(request.getParameter("id"));
		CarAdr.suprimerC(id);
		model.list(CarAdr.listAdresse(),CarAdr.listCarnet(),CarAdr.listAdresseParCarnet());
		request.getRequestDispatcher("/partDAO/listCarnet.jsp").forward(request, response);
	
	}
    if (path.equals("/deleteAdress")) {
    	int id=Integer.parseInt(request.getParameter("idAdr"));
		CarAdr.suprimerAdr(id);
		model.list(CarAdr.listAdresse(),CarAdr.listCarnet(),CarAdr.listAdresseParCarnet());
		request.getRequestDispatcher("/partDAO/listCarnet.jsp").forward(request, response);
	
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
		if(path.equals("/pageAdd")) {
			String nom=request.getParameter("nom");
			String ville=request.getParameter("ville");
			String rue=request.getParameter("nomRue");
			int num=Integer.parseInt(request.getParameter("numRue"));
			Carnet c=new Carnet(nom);
			Adress adr =new Adress(ville, rue, num);
			c=CarAdr.save(c, adr);
			model.list(CarAdr.listAdresse(),CarAdr.listCarnet(),CarAdr.listAdresseParCarnet());
			request.getRequestDispatcher("/partDAO/listCarnet.jsp").forward(request, response);
		}
		if (path.equals("/modifierNomCarnet")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String nom=request.getParameter("nom");
			CarAdr.modifierCarnet(id,nom);
			model.list(CarAdr.listAdresse(),CarAdr.listCarnet(),CarAdr.listAdresseParCarnet());
			request.getRequestDispatcher("/partDAO/listCarnet.jsp").forward(request, response);
		}
		if (path.equals("/modifierAdress")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String ville=request.getParameter("ville");
			String rue=request.getParameter("rue");
			int num=Integer.parseInt(request.getParameter("num"));
			CarAdr.modifierAdress(id,ville,rue,num);
			model.list(CarAdr.listAdresse(),CarAdr.listCarnet(),CarAdr.listAdresseParCarnet());
			request.getRequestDispatcher("/partDAO/listCarnet.jsp").forward(request, response);
		}
		
	}
}
