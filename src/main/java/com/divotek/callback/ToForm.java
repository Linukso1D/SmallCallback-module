/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.callback;

import javax.swing.DefaultListModel;

/**
 *
 * @author maxxl
 */
public class ToForm
{
   DefaultListModel listModel;
   
   private ToForm()
   {
		listModel= new DefaultListModel();
   }
   
   public static ToForm getInstance()
   {
	return ToFormHolder.INSTANCE;
   }
   
   private static class ToFormHolder
   {

	private static final ToForm INSTANCE = new ToForm();

   }

   public void initState(String phone)
   {
	 listModel.addElement(phone);
   }
   public  DefaultListModel GetListModel()
   {
   return listModel;
   }
 }
