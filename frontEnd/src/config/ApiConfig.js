import axios from "axios"

export const API_BASE_URL = 'localhost:1999'

const jwt = localStorage.getItem("jwt")

export const baseApi = axios.create({
    baseURL:API_BASE_URL,
    headers:{
        "Authorization":`Bearer ${jwt}`,
        'Content-Type':"application/json"
    }
})