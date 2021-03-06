package org.codeforafrica.citizenreporter.starreports.networking;

import org.codeforafrica.citizenreporter.starreports.WordPress;
import org.codeforafrica.citizenreporter.starreports.models.Blog;
import org.codeforafrica.citizenreporter.starreports.models.AccountHelper;
import org.wordpress.android.util.StringUtils;

public class OAuthAuthenticator implements Authenticator {
    @Override
    public void authenticate(final AuthenticatorRequest request) {
        String siteId = request.getSiteId();
        String token = AccountHelper.getDefaultAccount().getAccessToken();

        if (siteId != null) {
            // Get the token for a Jetpack site if needed
            Blog blog = WordPress.wpDB.getBlogForDotComBlogId(siteId);

            if (blog != null) {
                String jetpackToken = blog.getApi_key();

                // valid OAuth tokens are 64 chars
                if (jetpackToken != null && jetpackToken.length() == 64 && !blog.isDotcomFlag()) {
                    token = jetpackToken;
                }
            }
        }

        request.sendWithAccessToken(StringUtils.notNullStr(token));
    }
}
