import {defineStore} from 'pinia'

export const useIfLogin = defineStore('iflogin', ()=>{
    let if_login:boolean = false
    return {
        if_login
    }
})