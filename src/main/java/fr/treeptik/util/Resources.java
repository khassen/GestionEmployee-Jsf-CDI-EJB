/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the 
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.treeptik.util;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.clientservice.wsimportamazone.AWSECommerceService;
import fr.treeptik.clientservice.wsimportamazone.AWSECommerceServicePortType;
import fr.treeptik.clientservice.wsimportmeteo.Weather;
import fr.treeptik.clientservice.wsimportmeteo.WeatherSoap;


public class Resources {

	@Produces
    @PersistenceContext
    private EntityManager em;

    @Produces
    //InjectionPoint : permet de trouver ou il été injecter le logger partout dans le code
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    //lié à jaxContext: c a d qu il l injecte tout le temps et ou je veux
    @RequestScoped
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
    @Produces
    @RequestScoped
    public WeatherSoap getWeatherSoap( ){
    	Weather service = new Weather();
    	WeatherSoap weatherSaop = service.getWeatherSoap();
    	return weatherSaop;
    	
    }
    
    @Produces
    @RequestScoped
    public AWSECommerceServicePortType getAWSECommerceServicePortType(){
    	AWSECommerceService aWSECommerceService = new AWSECommerceService();
    	AWSECommerceServicePortType awseCommerceServicePortType = aWSECommerceService.getAWSECommerceServicePort();
        return awseCommerceServicePortType;
    }

}
