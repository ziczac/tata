function TataValidator(formId)
{
  this.formobj = document.forms[formId];
  
  if (!this.formobj)
  {
      alert("Error: couldnot get Form object " + formId);
      return;
  }
  if (this.formobj.onsubmit)
  {
      this.formobj.old_onsubmit = this.formobj.onsubmit;
      this.formobj.onsubmit = null;
  }
  else
  {
      this.formobj.old_onsubmit = null;
  }
  this.formobj._sfm_form_name = formId;

  this.formobj.onsubmit = form_submit_handler;
}

TataValidator.prototype.addValidator = function()
{

}