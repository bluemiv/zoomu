package com.azu.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azu.action.ICommandAction;

public class DogController extends HttpServlet {
	private Map map = new HashMap();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doResult(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doResult(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("dogConfig");
		Properties pr = new Properties();
		FileInputStream f = null;

		try {
			f = new FileInputStream(props);
			pr.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (f != null) {
				try {
					f.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if end
		} // try end

		Iterator key = pr.keySet().iterator();

		while (key.hasNext()) {
			String command = (String) key.next();
			String className = pr.getProperty(command);

			try {
				Class commandClass = Class.forName(className);

				Object commandInstance = commandClass.newInstance();

				map.put(command, commandInstance);
			} catch (Exception e) {
				e.printStackTrace();
			} // try end
		} // while end
	}

	protected void doResult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		ICommandAction action = null;

		try {
			String command = request.getRequestURI();

			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length() + 1);
				System.out.println("command : " + command); // 확인
			}
			action = (ICommandAction) map.get(command);
			view = action.doProcess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} // try end
		
		RequestDispatcher dp = request.getRequestDispatcher(view);
		dp.forward(request, response);
	}

}
