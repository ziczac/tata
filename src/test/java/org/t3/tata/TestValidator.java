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
public class TestValidator extends TestCase
{
   public void testNotNullValidator()
   {
      Bean bean = new Bean("foo");
      bean.addValidator(new NotNullValidator(), "Empty is not allowed");

      // Null
      assertFalse(bean.isValid());

      // Empty
      bean.setValue("");
      assertFalse(bean.isValid());

      //
      bean.setValue("bar");
      assertTrue(bean.isValid());
   }

   public void testEmailValidator()
   {
      Bean bean = new Bean("foo");
      bean.addValidator(new EmailValidator(), "Email is not correct");

      // Null
      assertTrue(bean.isValid());

      // Empty
      bean.setValue("");
      assertTrue(bean.isValid());

      //
      bean.setValue("bar");
      assertFalse(bean.isValid());

      bean.setValue("*bar@gmail.com");
      assertFalse(bean.isValid());

      bean.setValue("_bar@gmail.com");
      assertTrue(bean.isValid());

      bean.setValue("-bar@gmail.com");
      assertTrue(bean.isValid());

      bean.setValue("bar@gmail.com");
      assertTrue(bean.isValid());
   }

   public void testMaxLengthValidator()
   {
      Bean bean = new Bean("foo");
      bean.addValidator(new MaxLengthValidator(5), "Empty is not allowed");

      // Null
      assertTrue(bean.isValid());

      // Empty
      bean.setValue("");
      assertTrue(bean.isValid());

      //
      bean.setValue("foo");
      assertTrue(bean.isValid());

      //
      bean.setValue("foo_bar");
      assertFalse(bean.isValid());
   }
}
