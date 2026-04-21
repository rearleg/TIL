from datetime import datetime, timezone, timedelta
today = str(datetime.now(timezone(timedelta(hours=9)))).split()[0]
print(today)