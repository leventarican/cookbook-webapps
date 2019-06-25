package com.github.leventarican;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * demonstrating CDI testing.
 * 
 * @author levent@protonmail.com
 */
@RunWith(Arquillian.class)
public class DeveloperTest {

	@Inject
	Developer dev;
	
	@Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClass(Developer.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        
        // console out the jar content
        System.out.println(jar.toString());
        
        return jar;
    }

	@Test
	public void testStep0() {
		String language = "kotlin";
		dev.code(System.out, language);
		String actual = dev.editor(language);
		String expected = "coding in vm: " + language;
		Assert.assertEquals(expected, actual);
	}

}
