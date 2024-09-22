import {defineStore} from 'pinia'

export const useIfLogin = defineStore('iflogin', ()=>{
    let ifLogin:boolean = false
    return {
        ifLogin
    }
})