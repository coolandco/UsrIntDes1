## User Interface Design

First experiences with UI and Git in sixt semester. This is a scenario where managers and admins exists in a user management. Managers can only change properties of other managers. But admins can change properties of everything. Also they can create and delete other admins and managers. Furthermore they can choose to logon as manager role.

Goal was, to write a control layer between the database and the UI **once** and then reuse it with differen UI scenarios.

Logins:
Sachbearbeiter role: leo PW: abc
Admin/Sachbearbeiter role: kevin PW: 123


- Schnittstellenschicht:
  plain comando line implementation
- SchnittstellenschichtGui:
  gui implementation
- SchnittstellenschichtWeb:
  web implementation
  
To run, start the "StartHS" class in each folder. Web implementation currently broken without tomcat webserver.
