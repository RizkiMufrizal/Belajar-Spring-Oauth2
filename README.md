# Belajar-Spring-Oauth2

Aplikasi ini dibuat dalam rangka belajar Spring Oauth2

Teknologi yang digunakan :
* Spring Boot
* Spring Data JPA
* Spring Security
* Spring Oauth2
* MariaDB
* Jackson
* Gson
* Tomcat 8
* Gradle

Cara Menjalankannya :

`gradle clean build bootRun`

aplikasi ini berjalan di Port 8888, portnya dapat diganti di dalam file `application.yml`
aplikasi ini stand by pada url : `http://localhost:8888`

Langkah - Langkah menggunakannya :

* buat user terlebih dahulu, silahkan gunakan aplikasi curl untuk post json dengan perintah berikut :
   
   ```sh
   curl -H "Accept: application/json" -H "Content-type: application/json" -d '{"username":"admin","password":"admin"}' http://localhost:8888/user
   ```
   kita akan save data user dengan username admin dan password admin jika berhasil maka akan tampil pesan :
   
   ```json
   {
        "Success":"Data Tersimpan"
   }
   ```	
* Disini kita menggunakan aplikasi command line curl untuk menguji dan menukar akses token
  adapun perintahnya adalah 
  
  `curl http://localhost:8888/user`
  
  maka akan keluar json seperti berikut :
     ```json
    {
        "error":"unauthorized",
        "error_description":"An Authentication object was not found in the SecurityContext"
    }
    ```
   yang artinya kita tidak dapat mengakses aplikasi tersebut disebabkan kita belum memiliki hak akses

* untuk dapat melakukan akses ke url tersebut maka kita harus request token terlebih dahulu, tuliskan sintak berikut :
   ```sh 
   curl -X POST -vu clientapp:123456 http://localhost:8888/oauth/token -H "Accept: application/json" -d "password=admin&username=admin&grant_type=password&scope=read&write&client_secret=123456&client_id=clientapp"
   ```

   sintak diatas kita akan melakukan post ke authorization servernya dengan content typenya application/json, disana kita mengirim password dan username kita yang nantinya akan di encoding menjadi base64 untuk
   clientapp adalah sebagai salah satu client yang kita daftarkan ke authorization server, authorization server dapat memberikan hak akses tulis, membaca kepada client yang telah di daftarkan
   
   jika berhasil dan sesuai maka akan di reponse token yang nantinya berfungsi untuk dapat mengakses resource aplikasi yang telah dibuat
   hasilnya seperti berikut :
   ```json
   {
        "access_token":"14a065d8-ac74-4435-b322-71c891ca58bb",
        "token_type":"bearer",
        "refresh_token":"b55bfe66-5954-4d61-a297-9feec84ea7c1",
        "expires_in":43199,
        "scope":"read"
   }
   ```
* langkah selanjutnya ambil access token tadi lalu lakukan request kembali ke resource dengan sintak :
	
  ```sh
  curl http://localhost:8888/user -H "Authorization: Bearer 14a065d8-ac74-4435-b322-71c891ca58bb"
  ```
  jika berhasil maka akan tampil seperti ini yang menandakan anda telah dapat mengakses resource/API :
  ```json
  [ 
    {
        "username":"admin",
        "password":"$2a$10$AQtHkNEhk12kceU3uSTS3uoMyQY82bwqR1OVGNobI86Se0doPBh/S",
        "enable":true,
        "userRoles":[
            {
               "idCustomerRole":"ff8081814b58d9ae014b58dbff640001",
               "role":"ROLE_USER"
            }
      ]
    }
  ]
```
