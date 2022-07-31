# Back-end App Saint Hospital!

Coded by Juan Camilo Castaño Patiño

# How to Use

The code was develop with IntelliJ IDEA, so this IDE is recommended to be oppened and run with it.

The application.properties has all the setting to run the aplication and automatically create the database. Pleaser remenber to set the password field on the field acording to your MySQL root password (you can also change the username if needed)

**spring.datasource.password = yourpassword**


# Required
This repository is set to work with the next front end app [here](https://github.com/midflandir/saintclairfront).

Alternatively you can run the app trought an API platform like Postman

# Restrictions
The backend and the from end will make some validations. If the fiels no comply with the requirements, it will not work till you add the right values on the fields:
specialty name: must havee max 100char min 5char
physician_in_charge: must have max 45 char min 10 char
patient name:must have max 45 shr min 10 char
age: can not be cero o less,