package com.shopacc.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.shopacc.model.AccountModel;


public class FormUtil {
	@SuppressWarnings("deprecation")
	public static  <T> T toModel(Class<T> tClass, HttpServletRequest request ) {
		T object = null;
		try {
			object = tClass.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return object;
	}
}
