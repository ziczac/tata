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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * ^                       #  start of the line
 * [_A-Za-z0-9-]+          #  must start with string in the bracket [ ], must contains one or more (+)
 * (                       #  start of group #1
 *   \\.[_A-Za-z0-9-]+     #     follow by a dot "." and string in the bracket [ ], must contains one or more (+)
 * )*                      #  end of group #1, this group is optional (*)
 *   @                     #     must contains a "@" symbol
 *    [A-Za-z0-9]+         #        follow by string in the bracket [ ], must contains one or more (+)
 *     (                   #     start of group #2 - first level TLD checking
 *      \\.[A-Za-z0-9]+    #       follow by a dot "." and string in the bracket [ ], must contains one or more (+)
 *     )*                  #     end of group #2, this group is optional (*)
 *     (                   #     start of group #3 - second level TLD checking
 *      \\.[A-Za-z]{2,}    #       follow by a dot "." and string in the bracket [ ], with minimum length of 2
 *     )                   #     end of group #3
 * $                       #  end of the line
 * </pre>
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class EmailValidator implements Validator<String>
{
   private Pattern pattern;

   private Matcher matcher;
   
   private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


   public EmailValidator()
   {
      pattern = Pattern.compile(EMAIL_PATTERN);
   }

   @Override
   public boolean validate(final String value)
   {
      if (value != null && !value.isEmpty())
      {
         matcher = pattern.matcher(value);
         return matcher.matches();
      }
      return true;
   }

   @Override
   public String clientCheckRegExp()
   {
      return "email";
   }
}
