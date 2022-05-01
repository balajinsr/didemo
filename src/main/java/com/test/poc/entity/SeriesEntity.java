package com.test.poc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="series")
public class SeriesEntity implements Serializable {
   private static final long serialVersionUID = 1L;
   
   @Id
   @Column(name="tagid", nullable=false)
   private String tagId;
   
   @Column(name="vr", nullable=false, length=50) 
   private String vr;
   
   @Column(name="value", nullable=false, length=500) 
   private String value;

   public String getTagId() {
      return tagId;
   }

   public void setTagId(String tagId) {
      this.tagId = tagId;
   }

   public String getVr() {
      return vr;
   }

   public void setVr(String vr) {
      this.vr = vr;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }
   
}
