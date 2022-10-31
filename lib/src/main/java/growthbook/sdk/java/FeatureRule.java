package growthbook.sdk.java;

import com.google.gson.JsonElement;
import growthbook.sdk.java.models.Namespace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;
import java.util.ArrayList;

/**
 * Overrides the defaultValue of a Feature. Has a number of optional properties
 *
 * <ul>
 * <li>condition (Condition) - Optional targeting condition</li>
 * <li>coverage (number) - What percent of users should be included in the experiment (between 0 and 1, inclusive)</li>
 * <li>force (any) - Immediately force a specific value (ignore every other option besides condition and coverage)</li>
 * <li>variations (any[]) - Run an experiment (A/B test) and randomly choose between these variations</li>
 * <li>key (string) - The globally unique tracking key for the experiment (default to the feature key)</li>
 * <li>weights (number[]) - How to weight traffic between variations. Must add to 1.</li>
 * <li>namespace (Namespace) - Adds the experiment to a namespace</li>
 * <li>hashAttribute (string) - What user attribute should be used to assign variations (defaults to id)</li>
 * </ul>
 * @param <ValueType> generic type for the value type for this experiment's variations.
 */
@Data
@Builder
@AllArgsConstructor
public class FeatureRule<ValueType> {
    @Nullable
    String key;

    @Nullable
    Float coverage;

    @Nullable
    ValueType force;

    @Nullable
    ArrayList<ValueType> variations;

    @Nullable
    ArrayList<Float> weights;

    @Nullable
    Namespace namespace;

    @Builder.Default
    String hashAttribute = "id";

    @Nullable
    JsonElement condition;
}
