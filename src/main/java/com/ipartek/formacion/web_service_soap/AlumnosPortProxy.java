package com.ipartek.formacion.web_service_soap;

public class AlumnosPortProxy implements com.ipartek.formacion.web_service_soap.AlumnosPort {
  private String _endpoint = null;
  private com.ipartek.formacion.web_service_soap.AlumnosPort alumnosPort = null;
  
  public AlumnosPortProxy() {
    _initAlumnosPortProxy();
  }
  
  public AlumnosPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initAlumnosPortProxy();
  }
  
  private void _initAlumnosPortProxy() {
    try {
      alumnosPort = (new com.ipartek.formacion.web_service_soap.AlumnosPortServiceLocator()).getAlumnosPortSoap11();
      if (alumnosPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)alumnosPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)alumnosPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (alumnosPort != null)
      ((javax.xml.rpc.Stub)alumnosPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ipartek.formacion.web_service_soap.AlumnosPort getAlumnosPort() {
    if (alumnosPort == null)
      _initAlumnosPortProxy();
    return alumnosPort;
  }
  
  public com.ipartek.formacion.web_service_soap.GetAlumnoResponse getAlumno(com.ipartek.formacion.web_service_soap.GetAlumnoRequest getAlumnoRequest) throws java.rmi.RemoteException{
    if (alumnosPort == null)
      _initAlumnosPortProxy();
    return alumnosPort.getAlumno(getAlumnoRequest);
  }
  
  
}