import { defineStore } from "pinia";

export const useIfLogined = defineStore("ifLogined", ()=>{
  let ifLogined:boolean = false;
  return{
    ifLogined
}

});