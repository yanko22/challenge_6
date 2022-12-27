create or replace procedure update_status(status_updated character varying)
language plpgsql
as $$
declare
	-- deklarasi variabel
	status_updated character varying := status;

begin
	-- update status dari available -> not available
	update seats set status = 'Not Available'
		where seat_number = seats.seat_number
		and studio_name = seats.studio_name;

	--commit;
end;$$