local userId=KEYS[1];
local prodId=KEYS[2];
local keyStore='SecKill_'..prodId;
local keyUser=keyStore..'_User';
local userExists=redis.call("sismember",keyUser,userId);
if tonumber(userExists)==1 then
	return 2;
end
local num=redis.call("get",keyStore);
if tonumber(num)<=0 then
	return 0;
else
	redis.call("decr",keyStore); 
	redis.call("sadd",keyUser,userId); 
end
return 1;