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
package org.t3.tata.client;

import org.t3.tata.Input;
import org.t3.tata.Validator;

import java.util.List;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class DefaultFormValidator implements FormValidator
{
   private StringBuilder str;

   public DefaultFormValidator(String formName)
   {
      str = new StringBuilder("var form  = new Validator(\"" + formName + "\");");
   }

   @Override
   public void addValidator(Input<Object> bean, List<Validator<Object>> validators)
   {
      for (Validator<Object> validator : validators)
      {
         str.append(generateJScript(bean.getName(), validator.clientCheckRegExp(), validator.errorMessage()));
      }
   }

   private Object generateJScript(String name, String clientCheckRegExp, String errorMessage)
   {
      return "form.addValidation('" + name + "', '" + clientCheckRegExp + "', '" + errorMessage + "');";
   }

   @Override
   public String toString()
   {
      return str.toString();
   }
}
