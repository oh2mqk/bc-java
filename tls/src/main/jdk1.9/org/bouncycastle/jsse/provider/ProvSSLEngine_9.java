package org.bouncycastle.jsse.provider;

import java.util.List;
import java.util.function.BiFunction;

import javax.net.ssl.SSLEngine;

class ProvSSLEngine_9
    extends ProvSSLEngine
{
    protected ProvSSLEngine_9(ProvSSLContextSpi context, ContextData contextData)
    {
        super(context, contextData);
    }

    protected ProvSSLEngine_9(ProvSSLContextSpi context, ContextData contextData, String host, int port)
    {
        super(context, contextData, host, port);
    }

    @Override
    public synchronized void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> selector)
    {
        sslParameters.setEngineAPSelector(JsseUtils_9.importAPSelector(selector));
    }

    @Override
    public synchronized BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector()
    {
        return JsseUtils_9.exportAPSelector(sslParameters.getEngineAPSelector());
    }
}
