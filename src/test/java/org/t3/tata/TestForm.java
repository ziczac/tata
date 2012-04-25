/*
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.t3.tata;

import junit.framework.TestCase;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class TestForm extends TestCase
{
   public void testForm()
   {
      Form form = new Form("form");
      Bean bean = new Bean("username", "bar");
      bean.addValidator(new NotNullValidator(), "Empty is not allowed");
      form.addInput(bean);
      
      bean = new Bean("email", "bar@foo.com");
      bean.addValidator(new EmailValidator(), "Email is not correct");
      form.addInput(bean);

      assertTrue(form.isValid());
   }
}
