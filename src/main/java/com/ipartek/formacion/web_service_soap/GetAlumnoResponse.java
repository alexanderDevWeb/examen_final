/**
 * GetAlumnoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.web_service_soap;

public class GetAlumnoResponse  implements java.io.Serializable {
    private com.ipartek.formacion.web_service_soap.AlumnoInfo alumnoInfo;

    public GetAlumnoResponse() {
    }

    public GetAlumnoResponse(
           com.ipartek.formacion.web_service_soap.AlumnoInfo alumnoInfo) {
           this.alumnoInfo = alumnoInfo;
    }


    /**
     * Gets the alumnoInfo value for this GetAlumnoResponse.
     * 
     * @return alumnoInfo
     */
    public com.ipartek.formacion.web_service_soap.AlumnoInfo getAlumnoInfo() {
        return alumnoInfo;
    }


    /**
     * Sets the alumnoInfo value for this GetAlumnoResponse.
     * 
     * @param alumnoInfo
     */
    public void setAlumnoInfo(com.ipartek.formacion.web_service_soap.AlumnoInfo alumnoInfo) {
        this.alumnoInfo = alumnoInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAlumnoResponse)) return false;
        GetAlumnoResponse other = (GetAlumnoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.alumnoInfo==null && other.getAlumnoInfo()==null) || 
             (this.alumnoInfo!=null &&
              this.alumnoInfo.equals(other.getAlumnoInfo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAlumnoInfo() != null) {
            _hashCode += getAlumnoInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAlumnoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", ">getAlumnoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alumnoInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "alumnoInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "alumnoInfo"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
