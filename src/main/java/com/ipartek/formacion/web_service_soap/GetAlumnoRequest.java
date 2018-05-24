/**
 * GetAlumnoRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.web_service_soap;

public class GetAlumnoRequest  implements java.io.Serializable {
    private java.lang.String nif;

    public GetAlumnoRequest() {
    }

    public GetAlumnoRequest(
           java.lang.String nif) {
           this.nif = nif;
    }


    /**
     * Gets the nif value for this GetAlumnoRequest.
     * 
     * @return nif
     */
    public java.lang.String getNif() {
        return nif;
    }


    /**
     * Sets the nif value for this GetAlumnoRequest.
     * 
     * @param nif
     */
    public void setNif(java.lang.String nif) {
        this.nif = nif;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAlumnoRequest)) return false;
        GetAlumnoRequest other = (GetAlumnoRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nif==null && other.getNif()==null) || 
             (this.nif!=null &&
              this.nif.equals(other.getNif())));
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
        if (getNif() != null) {
            _hashCode += getNif().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAlumnoRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", ">getAlumnoRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nif");
        elemField.setXmlName(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "nif"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
