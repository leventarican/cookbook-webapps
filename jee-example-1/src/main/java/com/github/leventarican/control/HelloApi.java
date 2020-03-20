package com.github.leventarican.control;

import javax.ejb.Remote;

/**
 * on server cluster we should use remote otherwise if same vm we can use @Local
 *
 * @author Levent
 */
@Remote
public interface HelloApi {

    public String ping();
}
