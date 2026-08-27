## Phase 0 Risk Register and Governance Cadence (v1)

Status: Approved baseline draft
Version: 1.0
Last Updated: 2026-08-26
Source backlog: [phase0_sprint-planning_backlog.md](phase0_sprint-planning_backlog.md)
Source acceptance criteria: [phase0_acceptance_criteria_v1.md](phase0_acceptance_criteria_v1.md)

### Purpose
Provide a ranked risk register, mitigation plan, ownership map, and operating governance cadence for Phase 0 and the start of Phase 1.

### Risk Scoring Model
- Likelihood: 1 (Low) to 5 (High)
- Impact: 1 (Low) to 5 (High)
- Risk Score: Likelihood x Impact
- Example: Likelihood 4 x Impact 5 = Score 20 (Critical)
- Priority:
1. Critical: 16-25
1. High: 10-15
1. Medium: 6-9
1. Low: 1-5

### Environment Decision Log
1. Modern development host baseline is WSL2 Debian 13 with OpenJDK.
1. This environment is for modernization and refactor work stages.
1. Legacy reproducibility requirements remain separately governed by the Phase 1 baseline environment process.
1. Operational environment assumptions baseline is documented in [phase0_operational_environment_assumptions_v1.md](phase0_operational_environment_assumptions_v1.md).

### Ranked Risk Register

| ID | Risk | Likelihood | Impact | Score | Priority | Owner Role | Mitigation | Trigger/Signal |
|---|---|---:|---:|---:|---|---|---|---|
| R-01 | Legacy applet/runtime behavior cannot be reproduced consistently in modern host environments | 4 | 5 | 20 | Critical | DEVOPS + J-LD | Use controlled VM baseline, lock legacy tool versions, run repeatability checks with fixed scripts | Baseline rerun results diverge |
| R-02 | Scope drift between legacy archival lane and modern lane | 4 | 4 | 16 | Critical | PM + TL | Enforce dual-lane decision log, reject unapproved scope changes in weekly triage | New tasks appear without lane assignment |
| R-03 | Underestimated effort due to unknowns in legacy build/dependency behavior | 4 | 4 | 16 | Critical | PM + TL + QA | Maintain 10-15% sprint buffer, track unknowns as explicit risks, re-estimate weekly | Velocity drops below committed load |
| R-04 | Accessibility and security guardrails defined but not adopted by execution work | 3 | 5 | 15 | High | QA + A11Y + SEC | Add guardrail checks to Definition of Done and issue templates | Stories closing without evidence links |
| R-05 | Licensing/compliance ambiguity around Java distribution and third-party dependencies | 3 | 5 | 15 | High | SEC + SME | Pin OpenJDK distribution policy and add dependency provenance checklist | Unclear vendor/version or missing license data |
| R-06 | Single-human contributor bottleneck causes schedule slippage | 5 | 3 | 15 | High | PM | Use role aliases for clarity, split work into smallest reviewable chunks, limit WIP | More than 3 simultaneous in-progress items |
| R-07 | Evidence artifacts become inconsistent or hard to audit | 3 | 4 | 12 | High | QA | Enforce standard artifact naming and storage conventions | Missing or non-standard evidence paths |
| R-08 | Stakeholder decision latency blocks closure gates | 2 | 4 | 8 | Medium | PM + TL + SME | Time-box reviews, use pre-read packets, capture default decision by date | Checklist items pending over one sprint |

### Governance Cadence

### Weekly Operating Rhythm
1. Weekly triage and risk review
- Cadence: 1x per week
- Duration: 45 minutes
- Facilitator: PM
- Required roles: PM, TL, QA, SEC
- Agenda:
1. Review closure checklist status
1. Review top 5 risks by score
1. Review blocked items and dependency bottlenecks
1. Confirm decisions and owners for next week

1. Weekly planning sync
- Cadence: 1x per week
- Duration: 30 minutes
- Facilitator: TL
- Required roles: TL, J-LD, W-LD, DEVOPS
- Agenda:
1. Validate technical assumptions
1. Confirm acceptance criteria impacts
1. Update estimate changes and priority order

1. Weekly evidence audit
- Cadence: 1x per week
- Duration: 20 minutes
- Facilitator: QA
- Required roles: QA, PM
- Agenda:
1. Verify evidence links for completed items
1. Flag missing artifacts
1. Log corrective actions

### Conformance Regression Dashboard (Phase 0 Version)
Track these minimum indicators in one table or board view:
1. Closure items complete (count/total)
1. Open critical risks (count)
1. Open high risks (count)
1. Blocked backlog items (count)
1. Evidence completeness for Done items (% with valid links)

### Escalation Path
1. Operational blocker under 3 business days: PM resolves in weekly triage.
1. Blocker over 3 business days or Critical risk increase: PM + TL immediate review.
1. Scope or compliance dispute: PM + TL + SME decision record within 2 business days.

### Change Control Rules
1. No backlog item is marked Done without evidence link.
1. Any scope change must include lane assignment (legacy vs modern) and owner.
1. Any estimate increase over 30% requires explicit note in risk register.

### Pull-Forward Rule (Solo Capacity)
1. Baseline commitments for the 4-week sprint remain fixed at sprint start.
1. Additional tasks may be pulled forward only when:
1. The task is unblocked.
1. Dependencies are satisfied.
1. Acceptance criteria are already defined.
1. Owner role is assigned.
1. Pulled-forward work must be labeled as pull-forward in the project tracker.
1. Pull-forward items must include evidence links before being marked Done.
1. Pull-forward work does not change committed sprint scope retroactively; it is tracked as bonus throughput.
1. If pulled-forward work creates new risk, add or update a risk entry in this register within the same week.

### Review and Approval Log
- PM (Chrisjen Avasarala): Approved, 2026-08-26
- TL (Josephus Miller): Approved, 2026-08-26
- QA (James Holden): Approved, 2026-08-26
- SEC (Bobbie Draper): Approved, 2026-08-26

### Version History
- v1.0 (2026-08-26): Initial risk register and governance cadence baseline.
- v1.1 (2026-08-26): Added Pull-Forward Rule for 4-week solo sprint execution.
- v1.2 (2026-08-26): Added risk-score example and environment decision log (WSL2 Debian 13 + OpenJDK).
- v1.3 (2026-08-26): Linked formal operational environment assumptions baseline.
