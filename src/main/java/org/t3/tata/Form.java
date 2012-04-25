package org.t3.tata;

import org.t3.tata.client.DefaultFormValidator;

import java.util.ArrayList;
import java.util.List;

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
      DefaultFormValidator formValidator = new DefaultFormValidator(name);

      for (Input bean : list)
      {
         List<Validator<Object>> validators = bean.getValidators();
         formValidator.addValidator(bean, validators);
      }

      return formValidator.toString();
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
