import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
@Component(
    {
        selector: 'app-user-register',
        templateUrl: './user-register.component.html',
        styleUrls: ['./user-register.component.css']
    }
)
export class UserRegisterComponent implements OnInit {
    private url = "http://52.204.84.98:8080/user/register";
    constructor(public http: HttpClient) { }
    ngOnInit() { }
    register() {
        const httpOptions = {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' })
        };
        this.http.post(this.url,
            {
                username: 'abc',
                password: "123456",
                email: "a@b.com",
                phone: "12345678900"
            }, httpOptions).subscribe((response: any) => { window.alert(response.message); });
    }
    greeting() {
        const api = 'http://52.204.84.98:8080/greeting';
        const options = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json'
            })
        };
        this.http.get<any>(api, options).subscribe(
            (response: any) => {
                window.alert(response.name);
            },
            (error: any) => {
                console.error('Error:', error);
            }
        );
    }
}


