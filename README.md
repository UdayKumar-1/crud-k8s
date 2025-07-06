# crud-k8s

📌 Project Overview
This project demonstrates a full-stack microservices architecture deployed on Kubernetes, integrating both frontend and backend components with service mesh capabilities.

🖥️ Frontend
Built with ReactJS

Features:

Registration Page

Login Page

CRUD Operations Page

🛠️ Backend Microservices

📦 user-service (Spring Boot)
- Handles user registration and Login
- Connects to a dedicated MySQL database

📦 crud-service (Spring Boot)
- Performs CRUD operations
- Connects to its own MySQL instance

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


# Download Istio CLI
curl -L https://istio.io/downloadIstio | sh -

# Navigate to the Istio directory
cd istio-1.26.2

# Add Istio CLI to your path
export PATH=$PWD/bin:$PATH

# Enable sidecar injection for the default namespace
kubectl label namespace crud istio-injection=enabled

# Install Istio with the demo profile
istioctl install --set profile=demo -y

kubectl apply -f istio-1.26.2/samples/addons

#check grafana,prometheus,jaeger,kiali are running or not.
kubectl get pods -n istio-system

#it will run http://localhost:3000 port by executing below command.

istioctl dashboard grafana

