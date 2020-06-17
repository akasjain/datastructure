package leetcode.challenge.june;

/**
 https://leetcode.com/problems/validate-ip-address/

 Validate IP Address
 Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.


 */
public class J16_ValidateIPAddress {
    public String validIPAddress(String IP) {
        String NEITHER = "Neither";
        if(IP.indexOf(".") > 0) {
            // can be IPV4
            String[] parts = IP.split("\\.");
            if(parts.length != 4 || !IP.endsWith(parts[3]))
                return NEITHER;

            for(String part : parts) {
                int num;
                try {
                    num = Integer.valueOf(part);
                } catch(NumberFormatException e) {
                    return NEITHER;
                }

                if(num > 255 || num < 0 || !Character.isDigit(part.charAt(0)) ||
                        (part.charAt(0) == '0' && part.length() > 1))
                    return NEITHER;
            }

            return "IPv4";

        } else if(IP.indexOf(":") > 0){
            // can be IPv6
            String[] parts = IP.split(":");
            if(parts.length != 8 || !IP.endsWith(parts[7]))
                return NEITHER;

            for(String part : parts) {
                if(part.length() > 4 || part.length() == 0)
                    return NEITHER;
                for(char ch : part.toCharArray()) {
                    if(Character.digit(ch, 16) == -1) {
                        return NEITHER;
                    }
                }
            }

            return "IPv6";
        }

        return NEITHER;
    }

    public static void main(String[] args) {
        J16_ValidateIPAddress obj = new J16_ValidateIPAddress();
        System.out.println(obj.validIPAddress("172.16.00.01"));
        System.out.println(obj.validIPAddress("172.16.254.1"));
        System.out.println(obj.validIPAddress("1e1.16.254.1"));
        System.out.println(obj.validIPAddress("0.0.0.-0"));
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
