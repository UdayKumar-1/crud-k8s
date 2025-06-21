# crud-k8s

📌 Project Overview
This project demonstrates a full-stack microservices architecture deployed on Kubernetes, integrating both frontend and backend components with service mesh capabilities.

🖥️ Frontend
Built with ReactJS

Features:

Registration Page

Login Page

CRUD Operations Page

🛠️ Backend Services
user-service (Spring Boot)

Handles user registration

Connected to UserService MySQL instance

crud-service (Spring Boot)

Manages CRUD operations

Connected to a separate CrudService MySQL instance

☸️ Kubernetes Components Used
Namespaces

Pods

Deployments

StatefulSets

Services

ConfigMaps

Secrets

PersistentVolumes (PV)

PersistentVolumeClaims (PVC)

🔗 Service Mesh (Istio)
Istio is used for:

Secure and efficient internal communication between services

Traffic routing and observability

No Ingress controller is used; Istio handles all service-level routing
