package com.aem.project.example.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

public interface MyTask {

    public String getTitle();

    public String getDescription();

    public String getLinkURL();

    public String getBtnTitle();

    public Resource getFile();

    public String getAlt();

    public String getOsgiConfig();

    public boolean getMyCheck();

    public String getPageDetails();
}
