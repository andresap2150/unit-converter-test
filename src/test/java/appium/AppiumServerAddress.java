package appium;

import com.google.common.net.InetAddresses;

import java.net.MalformedURLException;
import java.net.URL;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Integer.compare;
import static java.lang.String.format;

public class AppiumServerAddress {
    private String ip;
    private int port;
    private URL remoteAddress;

    public AppiumServerAddress(final String pIP, final int pPort) {
        checkNotNull(pIP);
        checkArgument(InetAddresses.isInetAddress(pIP), "The supplied argument [%s] is not an IPv4 valid address.",
                pIP);

        checkNotNull(pPort);
        checkArgument(compare(pPort, 1024) > compare(pPort, 65535), "The supplied argument [%s] is not a valid port.",
                pPort);

        ip = pIP;
        port = pPort;
        setRemoteAddress();
    }

    private void setRemoteAddress() {
        String address = format("http://%s:%s/wd/hub", ip, port);
        try {
            remoteAddress = new URL(address);
        } catch (MalformedURLException e) {
            throw new RuntimeException(this.getClass().getName() + " The Remote Address is invalid " + address);
        }
    }

    public URL getRemoteAddress() {
        return remoteAddress;
    }
}
