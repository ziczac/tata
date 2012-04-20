package org.t3.tata;

import java.util.ArrayList;

public class Form implements FormElement
{
   private String name;

   private ArrayList<Input<?>> list;

   public Form(String name)
   {
      this.name = name;
   }

   @Override
   public String getName()
   {
      return name;
   }

   public void addInput(Input<?> bean)
   {
      if (list == null)
      {
         list = new ArrayList<Input<?>>();
      }
      list.add(bean);
   }

   public String jScriptsForValidation()
   {
      StringBuilder str = new StringBuilder("var form  = new FormValidator(\"" + name + "\");");

      for (Input<?> bean : list)
      {
         bean.clientCheck(str);
      }

      return str.toString();
   }

   @Override
   public boolean isValid()
   {
      for (Input<?> bean : list)
      {
         if (!bean.isValid())
         {
            return false;
         }
      }
      return true;
   }
}
