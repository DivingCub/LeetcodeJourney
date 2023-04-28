function checkIfInstanceOf(obj: any, classFunction: any): boolean {

   if(obj ==null || typeof obj === "undefined" || typeof classFunction !=="function") return false;


   return Object(obj) instanceof classFunction;


};