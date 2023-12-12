package com.aem.project.example.core.models.impl;

import com.aem.project.example.core.config.OsgiConfigDemo;
import com.aem.project.example.core.models.MyTask;
import com.day.cq.commons.inherit.InheritanceValueMap;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Locale;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {MyTask.class},
        resourceType = {MyTaskImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MyTaskImpl implements MyTask {

    protected static final String RESOURCE_TYPE = "aem-project/components/mytask5";

    private final Logger _log = LoggerFactory.getLogger(getClass());

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String linkURL;

    @ValueMapValue
    private String btnTitle;

    @ChildResource
    private Resource file;

    @ValueMapValue
    private String alt;

    @OSGiService
    private OsgiConfigDemo osgiConfigDemo;

    @ValueMapValue
    private boolean myCheck;

    @Inject
    private InheritanceValueMap pageProperties;


    @Override
    public String getTitle() {
        _log.info("Get Title ========================>" + title);
        return title.toUpperCase();
    }

    @Override
    public String getDescription() {
        _log.debug("Get Description ========================>" + description);
        return description.toLowerCase();
    }

    @Override
    public String getLinkURL() {
        _log.debug("Get Link URL ========================>" + linkURL);
        return linkURL;
    }

    @Override
    public String getBtnTitle() {
        _log.debug("Get Button Title ========================>" + btnTitle);
        return btnTitle;
    }

    @Override
    public String getAlt() {
        _log.debug("Get Image Alt ========================>" + alt);
        return alt;
    }

    @Override
    public String getOsgiConfig() {
        return osgiConfigDemo.getServiceName();
    }

    @Override
    public boolean getMyCheck() {
        _log.debug("Get My Check ========================>" + myCheck);
        return myCheck;
    }

    @Override
    public String getPageDetails() {
        _log.debug("Getting Page properties as details " + pageProperties.getInherited("details", "dft"));
        return pageProperties.getInherited("details", "dft");
    }

    @Override
    public Resource getFile() {
        _log.debug("File ========================>" + file.getPath());
        return file;
    }


}
