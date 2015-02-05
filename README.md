# Belajar-Spring-Oauth2

Aplikasi ini dibuat dalam rangka belajar Spring Oauth2

Teknologi yang digunakan :
* Spring Boot
* Spring Data JPA
* Spring Security
* Spring Oauth2
* MariaDB
* Jackson
* Tomcat 8
* Gradle

Cara Menjalankannya :

Gradle clean build bootRun

aplikasi ini berjalan di Port 8888, portnya dapat diganti di dalam file application.yml
aplikasi ini stand by pada url : http://localhost:8888/user

Langkah - Langkah menggunakannya :

* Disini kita menggunakan aplikasi command line curl untuk menguji dan menukar akses token
  adapun perintahnya adalah 
  
  curl http://localhost:8888/user
  
  maka akan keluar json seperti berikut :
  
    {
        "error":"unauthorized",
        "error_description":"An Authentication object was not found in the SecurityContext"
    }
    
   yang artinya kita tidak dapat mengakses aplikasi tersebut disebabkan kita belum memiliki hak akses

* untuk dapat melakukan akses ke url tersebut maka kita harus request token terlebih dahulu, tuliskan sintak berikut :
    
   curl -X POST -vu clientapp:123456 http://localhost:8888/oauth/token -H "Accept: application/json" -d "password=12345&username=rizki&grant_type=password&scope=read&write&client_secret=123456&client_id=clientapp"
     
   sintak diatas kita akan melakukan post ke authorization servernya dengan content typenya application/json, disana kita mengirim password dan username kita yang nantinya akan di encoding menjadi base64 untuk
   clientapp adalah sebagai salah satu client yang kita daftarkan ke authorization server, authorization server dapat memberikan hak akses tulis, membaca kepada client yang telah di daftarkan
   
   jika berhasil dan sesuai maka akan di reponse token yang nantinya berfungsi untuk dapat mengakses resource aplikasi yang telah dibuat
   hasilnya seperti berikut :
   
   {
        "access_token":"14a065d8-ac74-4435-b322-71c891ca58bb",
        "token_type":"bearer",
        "refresh_token":"b55bfe66-5954-4d61-a297-9feec84ea7c1",
        "expires_in":43199,
        "scope":"read"
   }
   
* langkah selanjutnya ambil access token tadi lalu lakukan request kembali ke resource dengan sintak :
  curl http://localhost:8888/user -H "Authorization: Bearer 14a065d8-ac74-4435-b322-71c891ca58bb"
  
  jika berhasil maka akan tampil seperti ini yang menandakan anda telah dapat mengakses resource/API :
  
  [ 
    {
        "username":"rizki",
        "password":"$2a$08$LOUVLE2yC5SNm/tHGGb5zuh.wziqZT8AzKrqVyi8S7vk/i4TUM3Iq",
        "enable":true,
        "userRoles":
            [
                {
                    "idCustomerRole":"1",
                    "role":"ROLE_ADMIN"
                }
            ]
    }
  ]