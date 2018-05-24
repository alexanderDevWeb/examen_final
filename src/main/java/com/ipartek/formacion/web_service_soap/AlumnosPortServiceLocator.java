/**
 * AlumnosPortServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.web_service_soap;

public class AlumnosPortServiceLocator extends org.apache.axis.client.Service implements com.ipartek.formacion.web_service_soap.AlumnosPortService {

    public AlumnosPortServiceLocator() {
    }


    public AlumnosPortServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AlumnosPortServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AlumnosPortSoap11
    private java.lang.String AlumnosPortSoap11_address = "http://192.168.0.42:8080/ws";

    public java.lang.String getAlumnosPortSoap11Address() {
        return AlumnosPortSoap11_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AlumnosPortSoap11WSDDServiceName = "AlumnosPortSoap11";

    public java.lang.String getAlumnosPortSoap11WSDDServiceName() {
        return AlumnosPortSoap11WSDDServiceName;
    }

    public void setAlumnosPortSoap11WSDDServiceName(java.lang.String name) {
        AlumnosPortSoap11WSDDServiceName = name;
    }

    public com.ipartek.formacion.web_service_soap.AlumnosPort getAlumnosPortSoap11() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AlumnosPortSoap11_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAlumnosPortSoap11(endpoint);
    }

    public com.ipartek.formacion.web_service_soap.AlumnosPort getAlumnosPortSoap11(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ipartek.formacion.web_service_soap.AlumnosPortSoap11Stub _stub = new com.ipartek.formacion.web_service_soap.AlumnosPortSoap11Stub(portAddress, this);
            _stub.setPortName(getAlumnosPortSoap11WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAlumnosPortSoap11EndpointAddress(java.lang.String address) {
        AlumnosPortSoap11_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ipartek.formacion.web_service_soap.AlumnosPort.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ipartek.formacion.web_service_soap.AlumnosPortSoap11Stub _stub = new com.ipartek.formacion.web_service_soap.AlumnosPortSoap11Stub(new java.net.URL(AlumnosPortSoap11_address), this);
                _stub.setPortName(getAlumnosPortSoap11WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AlumnosPortSoap11".equals(inputPortName)) {
            return getAlumnosPortSoap11();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "AlumnosPortService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "AlumnosPortSoap11"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AlumnosPortSoap11".equals(portName)) {
            setAlumnosPortSoap11EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
