/*
 * Matrix Gateway Daemon
 * Copyright (C) 2018 Kamax Sarl
 *
 * https://www.kamax.io/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.mxgwd.model;

import com.google.gson.JsonObject;
import io.kamax.matrix.json.GsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Response {

    public static Response rejectByPolicy() {
        JsonObject body = new JsonObject();
        body.addProperty("errcode", "M_FORBIDDEN");
        body.addProperty("error", "Not allowed by policy");
        Response resOut = new Response();
        resOut.setStatus(403);
        resOut.setBody(GsonUtil.get().toJson(body).getBytes());
        return resOut;
    }

    private int status;
    private Map<String, List<String>> headers = new HashMap<>();
    private byte[] body;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public Optional<byte[]> getBody() {
        return Optional.ofNullable(body);
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

}
