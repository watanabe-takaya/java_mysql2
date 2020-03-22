package info.searchman.lesson.java_mysql;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����R�[�h�̐ݒ�
		request.setCharacterEncoding("Windows-31J");

		// mode�̎擾
		String mode = request.getParameter("mode");

		// ���s�X�e�[�^�X�̐錾
		String status = "�������܂���";

		// JavaBeans�̏�����
		ShainBeans shain = new ShainBeans(request);

		switch (mode) {

		case "add": // �o�^
			if (shain.addData() == false) {
				status = "���s���܂���";
			}
			break;

		case "delete": // �폜
			if (shain.deleteData() == false) {
				status = "���s���܂���";
			}
			break;

		case "change": // �ύX
			request.setAttribute("shain", shain);
			request.getRequestDispatcher("/change.jsp").forward(request, response);
			return;

		case "del_add": // �ύX�m��
			if (!(shain.deleteData() && shain.addData())) {
				status = "���s���܂���";
			}
			break;
		}

		// status���Z�b�g���āAresult.jsp�ɓ]��
		request.setAttribute("status", status);
		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
}
