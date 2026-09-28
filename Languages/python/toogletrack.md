Organizations:
```bash
curl -u be587be0dc61bd7e0a927c50e33526cb:api_token \
        -H "Content-Type: application/json" \
        -d '{"name":"Your Organization","workspace_name":"Your Workspace"}' \
        -X POST https://api.track.toggl.com/api/v9/organizations

{"id":9355838,"name":"Your Organization","workspace_id":9354120,"workspace_name":"Your Workspace"}
```

Workspace:
```bash
curl -u be587be0dc61bd7e0a927c50e33526cb:api_token \
  -H "Content-Type: application/json" \
  -X GET curl  https://api.track.toggl.com/api/v9/workspaces/9354120
```

