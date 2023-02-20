package conntrol;

import com.example.binh_c10.model.dto.StudentDto;
import com.example.binh_c10.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentServlet", urlPatterns = {"/", "/students", "/student/detail",
        "/student/add", "/student/edit",
        "/student/remove", "/student/searchByName"})
public class StudentController extends HttpServlet {
    private StudentService studentService = null;

    @Override
    public void init() throws ServletException {

        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/":
            case "/students":
                req.setAttribute("students", studentService.findAll());
                req.getRequestDispatcher("/WEB-INF/view/manager.jsp").forward(req, resp);
                break;
            case "/student/detail":
                Integer detailId = Integer.valueOf((req.getParameter("id")));
                req.setAttribute("students", studentService.find(detailId));
                req.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(req, resp);
                break;
            case "/student/add":
                req.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(req, resp);
                break;
            case "/student/edit":
                Integer editId = Integer.valueOf((req.getParameter("id")));
                req.setAttribute("students", studentService.find(editId));
                req.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(req, resp);
                break;
            case "/student/remove":
                String removeId = (req.getParameter("id"));
                studentService.remove(removeId);
                resp.sendRedirect(req.getContextPath() + "/students");
                break;
            case "/student/searchByName":
                String searchName = req.getParameter("name");
                studentService.seacrchByName(searchName);
                req.setAttribute("students", studentService.seacrchByName(searchName));
                req.getRequestDispatcher("/WEB-INF/view/manager.jsp").forward(req, resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getServletPath();
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String classRoom =req.getParameter("class");
        StudentDto studentDto = new StudentDto(id, name,dob,address,phone, email, classRoom);

        switch (action) {
            case "/student/add":
                studentService.add(studentDto);
                resp.sendRedirect(req.getContextPath() + "/students");
                break;
            case "/staff/edit":
                id = Integer.valueOf((req.getParameter("id")));
                StudentDto editingStudent = studentService.find(id);
                editingStudent.setName(name);
                editingStudent.setDob(dob);
                editingStudent.setAddress(address);
                editingStudent.setPhone(phone);
                editingStudent.setEmail(email);
                editingStudent.setClassRoom(classRoom);
                studentService.edit(editingStudent);
                resp.sendRedirect(req.getContextPath() + "/students");
                break;
        }
    }
}

