import { defineStore } from "pinia";

export const useIfLogined = defineStore("ifLogined", ()=>{
  let if_logined:boolean = false;
  return{
    if_logined
}

});