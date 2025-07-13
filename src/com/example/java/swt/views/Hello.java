package com.example.java.swt.views;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.part.ViewPart;
import org.eclipse.core.runtime.FileLocator;

import java.net.URL;


public class Hello extends ViewPart {

    public static final String ID = "com.example.java.swt.views.Hello"; 

    @Override
    public void createPartControl(Composite parent) {
    	parent.setLayout(new FillLayout()); 

        Browser browser = new Browser(parent, SWT.NONE);
        
        try {
        	URL resourceUrl = FileLocator.toFileURL(getClass().getClassLoader().getResource("web/build/index.html"));
        	java.io.File htmlFile = new java.io.File(resourceUrl.toURI());
            String normalizedPath = htmlFile.toURI().toString();  
        	browser.setUrl(normalizedPath);
        	
        	//browser.setUrl("www.google.com");

        } catch (Exception e) {
        	System.out.println("Exception");
            e.printStackTrace();
        }

    }

    @Override
    public void setFocus() {
        // Optional: set focus to a control if needed
    }
}
