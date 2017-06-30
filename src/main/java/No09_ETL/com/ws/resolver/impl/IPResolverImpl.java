package No09_ETL.com.ws.resolver.impl;

import No09_ETL.com.ws.annotation.ETLField;
import No09_ETL.com.ws.annotation.Resolver;
import No09_ETL.com.ws.beans.impl.ETLedLogBean;
import No09_ETL.com.ws.resolver.IPResolver;

/**
 *
 */
@Resolver
public class IPResolverImpl implements IPResolver {
    @ETLField
    private String ip;
    @ETLField
    private String country;


    public ETLedLogBean parser(ETLedLogBean etLedLogBean)  {
        return etLedLogBean;
    }

}
