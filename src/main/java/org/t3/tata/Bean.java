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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class Bean implements Input<String>
{
   public Map<Validator<String>, String> map;

   private String name;

   private String value;

   public Bean(String name)
   {
      this(name, null);
   }

   public Bean(String name, String value)
   {
      this.name = name;
      this.value = value;
   }

   @Override
   public String getName()
   {
      return name;
   }

   public void setValue(String value)
   {
      this.value = value;
   }
   
   public String getValue()
   {
      return this.value;
   }

   @Override
   public void addValidator(Validator<String> validator, String message)
   {
      if (map == null)
      {
         map = new HashMap<Validator<String>, String>();
      }
      map.put(validator, message);
   }
   
   @Override
   public List<Validator<String>> getValidators()
   {
      return new ArrayList<Validator<String>>(map.keySet());
   }

   public boolean isValid()
   {
      for (Validator<String> validator : map.keySet())
      {
         if (!validator.validate(value))
         {
            return false;
         }
      }
      return true;
   }
}
